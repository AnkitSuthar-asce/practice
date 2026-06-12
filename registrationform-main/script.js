const form = document.getElementById('registration-form');
const fullName = document.getElementById('full-name');
const email = document.getElementById('email');
const mobile = document.getElementById('mobile');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirm-password');
const dob = document.getElementById('dob');
const city = document.getElementById('city');
const terms = document.getElementById('terms');
const registerBtn = document.getElementById('register-btn');
const togglePassword = document.getElementById('toggle-password');
const strengthBar = document.getElementById('strength-bar');
const strengthText = document.getElementById('strength-text');
const loader = document.getElementById('loader');
const successBanner = document.getElementById('success-banner');

const fields = [
    { el: fullName, validate: validateName, next: email },
    { el: email, validate: validateEmail, next: mobile },
    { el: mobile, validate: validateMobile, next: password },
    { el: password, validate: validatePassword, next: confirmPassword },
    { el: confirmPassword, validate: validateConfirmPassword, next: dob },
    { el: dob, validate: validateDOB, next: city },
    { el: city, validate: validateCity, next: null }
];

fields.forEach(field => {
    field.el.addEventListener('blur', () => {
        const isValid = field.validate();
        if (isValid && field.next) {
            field.next.focus();
        }
        checkFormValidity();
    });
});

password.addEventListener('input', () => {
    updatePasswordStrength();
    validatePassword();
    if (confirmPassword.value) validateConfirmPassword();
    checkFormValidity();
});

confirmPassword.addEventListener('input', () => {
    validateConfirmPassword();
    checkFormValidity();
});

document.querySelectorAll('input[name="gender"]').forEach(radio => {
    radio.addEventListener('change', () => {
        validateGender();
        checkFormValidity();
    });
});

terms.addEventListener('change', () => {
    validateTerms();
    checkFormValidity();
});

togglePassword.addEventListener('click', () => {
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    togglePassword.textContent = type === 'password' ? '👁️' : '🙈';
});

function setStatus(el, errorElId, isValid, message) {
    const errorEl = document.getElementById(errorElId);
    if (isValid) {
        el.classList.remove('invalid');
        el.classList.add('valid');
        errorEl.textContent = '';
    } else {
        el.classList.remove('valid');
        el.classList.add('invalid');
        errorEl.textContent = message;
    }
}

function validateName() {
    const val = fullName.value.trim();
    const isValid = val !== '' && /^[a-zA-Z\s]+$/.test(val);
    setStatus(fullName, 'name-error', isValid, 'Enter a valid name');
    return isValid;
}

function validateEmail() {
    const val = email.value.trim();
    const isValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(val);
    setStatus(email, 'email-error', isValid, 'Enter a valid email address');
    return isValid;
}

function validateMobile() {
    const val = mobile.value.trim();
    const isValid = /^\d{10}$/.test(val);
    setStatus(mobile, 'mobile-error', isValid, 'Enter a 10-digit mobile number');
    return isValid;
}

function validatePassword() {
    const val = password.value;
    const hasLength = val.length >= 8;
    const hasUpper = /[A-Z]/.test(val);
    const hasNum = /[0-4]/.test(val) || /[5-9]/.test(val);
    const hasSpecial = /[^A-Za-z0-9]/.test(val);
    const isValid = hasLength && hasUpper && hasNum && hasSpecial;
    setStatus(password, 'password-error', isValid, 'Weak password');
    return isValid;
}

function validateConfirmPassword() {
    const isValid = confirmPassword.value === password.value && confirmPassword.value !== '';
    setStatus(confirmPassword, 'confirm-password-error', isValid, 'Passwords do not match');
    return isValid;
}

function validateGender() {
    const checked = document.querySelector('input[name="gender"]:checked');
    const errorEl = document.getElementById('gender-error');
    if (checked) {
        errorEl.textContent = '';
        return true;
    } else {
        errorEl.textContent = 'Select your gender';
        return false;
    }
}

function validateDOB() {
    const val = dob.value;
    if (!val) {
        setStatus(dob, 'dob-error', false, 'You must be 18+');
        return false;
    }
    const birthDate = new Date(val);
    const today = new Date();
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    const isValid = age >= 18;
    setStatus(dob, 'dob-error', isValid, 'You must be 18+');
    return isValid;
}

function validateCity() {
    const isValid = city.value !== '';
    setStatus(city, 'city-error', isValid, 'Select your city');
    return isValid;
}

function validateTerms() {
    const isValid = terms.checked;
    const errorEl = document.getElementById('terms-error');
    if (isValid) {
        errorEl.textContent = '';
        return true;
    } else {
        errorEl.textContent = 'Accept terms to continue';
        return false;
    }
}

function updatePasswordStrength() {
    const val = password.value;
    let score = 0;
    if (val.length >= 8) score++;
    if (/[A-Z]/.test(val)) score++;
    if (/[0-9]/.test(val)) score++;
    if (/[^A-Za-z0-9]/.test(val)) score++;

    strengthBar.className = 'strength-bar';
    strengthText.className = 'strength-text';

    if (val === '') {
        strengthText.textContent = '';
    } else if (score <= 2) {
        strengthBar.classList.add('weak');
        strengthText.classList.add('weak');
        strengthText.textContent = 'Weak';
    } else if (score === 3) {
        strengthBar.classList.add('medium');
        strengthText.classList.add('medium');
        strengthText.textContent = 'Medium';
    } else if (score === 4) {
        strengthBar.classList.add('strong');
        strengthText.classList.add('strong');
        strengthText.textContent = 'Strong';
    }
}

function checkFormValidity() {
    const checked = document.querySelector('input[name="gender"]:checked');
    const hasName = fullName.value.trim() !== '' && /^[a-zA-Z\s]+$/.test(fullName.value.trim());
    const hasEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email.value.trim());
    const hasMobile = /^\d{10}$/.test(mobile.value.trim());
    const valP = password.value;
    const hasPass = valP.length >= 8 && /[A-Z]/.test(valP) && (/[0-9]/.test(valP)) && /[^A-Za-z0-9]/.test(valP);
    const hasMatch = confirmPassword.value === password.value && confirmPassword.value !== '';
    const hasCity = city.value !== '';
    const hasTerms = terms.checked;
    
    let hasAge = false;
    if (dob.value) {
        const birthDate = new Date(dob.value);
        const today = new Date();
        let age = today.getFullYear() - birthDate.getFullYear();
        const m = today.getMonth() - birthDate.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) age--;
        hasAge = age >= 18;
    }

    const allValid = hasName && hasEmail && hasMobile && hasPass && hasMatch && checked && hasAge && hasCity && hasTerms;
    registerBtn.disabled = !allValid;
    return allValid;
}

form.addEventListener('submit', (e) => {
    e.preventDefault();
    if (!checkFormValidity()) return;

    form.classList.add('hidden');
    loader.classList.remove('hidden');

    const userData = {
        name: fullName.value.trim(),
        email: email.value.trim(),
        mobile: mobile.value.trim(),
        gender: document.querySelector('input[name="gender"]:checked').value,
        dob: dob.value,
        city: city.value
    };

    setTimeout(() => {
        loader.classList.add('hidden');
        successBanner.classList.remove('hidden');
        localStorage.setItem('registeredUser', JSON.stringify(userData));
    }, 2000);
});
