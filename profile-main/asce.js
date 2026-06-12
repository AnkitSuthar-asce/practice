document.querySelector("form").addEventListener("submit", function(event) {
    event.preventDefault();
    const name = this.querySelector('input[placeholder="Your Name"]').value;
    const email = this.querySelector('input[placeholder="name@domain.com"]').value;
    const message = this.querySelector('textarea').value;
    const subject = encodeURIComponent("Portfolio Contact from " + name);
    const body = encodeURIComponent("Name: " + name + "\nEmail: " + email + "\n\nMessage:\n" + message);
    window.location.href = "mailto:ankitsuthar117@://gmail.com" + subject + "&body=" + body;
    this.reset();
});
