const API_URL = "http://localhost:3000/students";

const studentForm = document.getElementById("student-form");
const studentIdInput = document.getElementById("student-id");
const studentNameInput = document.getElementById("student-name");
const studentEmailInput = document.getElementById("student-email");
const studentCourseInput = document.getElementById("student-course");
const submitBtn = document.getElementById("submit-btn");
const cancelBtn = document.getElementById("cancel-btn");
const formTitle = document.getElementById("form-title");
const studentsTbody = document.getElementById("students-tbody");
const searchInput = document.getElementById("search-input");
const toastContainer = document.getElementById("toast-container");

let allStudents = [];
let isEditMode = false;

document.addEventListener("DOMContentLoaded", fetchAndRenderStudents);
studentForm.addEventListener("submit", handleFormSubmit);
cancelBtn.addEventListener("click", resetFormState);
searchInput.addEventListener("input", handleSearch);

async function fetchAndRenderStudents() {
    try {
        const res = await fetch(API_URL);
        if (!res.ok) throw new Error("Could not fetch database records.");
        
        allStudents = await res.json();
        renderTable(allStudents);
    } catch (err) {
        showToast(err.message, "danger");
    }
}

function renderTable(studentsList) {
    studentsTbody.innerHTML = "";
    
    if (studentsList.length === 0) {
        studentsTbody.innerHTML = `<tr><td colspan="5" style="text-align:center;">No students matched or entry list empty.</td></tr>`;
        return;
    }

    studentsList.forEach(student => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.course}</td>
            <td>
                <div class="action-btns">
                    <button class="btn btn-edit" onclick="initiateEdit('${student.id}')">Edit</button>
                    <button class="btn btn-delete" onclick="triggerDelete('${student.id}')">Delete</button>
                </div>
            </td>
        `;
        studentsTbody.appendChild(tr);
    });
}

async function handleFormSubmit(e) {
    e.preventDefault();

    const studentData = {
        name: studentNameInput.value.trim(),
        email: studentEmailInput.value.trim(),
        course: studentCourseInput.value.trim()
    };

    try {
        if (isEditMode) {
            const id = studentIdInput.value;
            const res = await fetch(`${API_URL}/${id}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(studentData)
            });
            if (!res.ok) throw new Error("Failed updating chosen record entry.");
            showToast("Student profile saved successfully.", "success");
        } else {
            const res = await fetch(API_URL, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(studentData)
            });
            if (!res.ok) throw new Error("Failed adding student entry to system.");
            showToast("New student registration complete.", "success");
        }

        resetFormState();
        await fetchAndRenderStudents();
    } catch (err) {
        showToast(err.message, "danger");
    }
}

function initiateEdit(id) {
    const target = allStudents.find(s => String(s.id) === String(id));
    if (!target) return;

    isEditMode = true;
    formTitle.textContent = "Modify Student Details";
    submitBtn.textContent = "Update Student";
    cancelBtn.classList.remove("hidden");

    studentIdInput.value = target.id;
    studentNameInput.value = target.name;
    studentEmailInput.value = target.email;
    studentCourseInput.value = target.course;
    
    studentNameInput.focus();
}

async function triggerDelete(id) {
    const confirmation = confirm("Are you sure you want to delete this student record permanent?");
    if (!confirmation) return;

    try {
        const res = await fetch(`${API_URL}/${id}`, { method: "DELETE" });
        if (!res.ok) throw new Error("Could not execute record purge request.");

        showToast("Student profile purged from infrastructure.", "warning");
        if (isEditMode && studentIdInput.value === String(id)) resetFormState();
        await fetchAndRenderStudents();
    } catch (err) {
        showToast(err.message, "danger");
    }
}

function resetFormState() {
    isEditMode = false;
    formTitle.textContent = "Add New Student";
    submitBtn.textContent = "Add Student";
    cancelBtn.classList.add("hidden");
    studentForm.reset();
    studentIdInput.value = "";
}

function handleSearch(e) {
    const term = e.target.value.toLowerCase();
    const filtered = allStudents.filter(student => 
        student.name.toLowerCase().includes(term)
    );
    renderTable(filtered);
}

function showToast(msg, type = "success") {
    const toast = document.createElement("div");
    toast.className = `toast ${type}`;
    toast.textContent = msg;

    toastContainer.appendChild(toast);
    setTimeout(() => {
        toast.remove();
    }, 4000);
}
