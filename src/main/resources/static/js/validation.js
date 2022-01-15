(function () {

    $('#password, #password_confirm').on('keyup', function () {
        const passwordConfirm = $('#password_confirm');
        const password = $('#password');
        passwordConfirm[0].setCustomValidity(passwordConfirm.val() !== password.val() ? "Passwords do not match." : "");
    });
    $('#email, #email_confirm').on('keyup', function () {
        const emailConfirm = $('#email_confirm');
        const email = $('#email');
        emailConfirm[0].setCustomValidity(emailConfirm.val() !== email.val() ? "Passwords do not match." : "");
    });
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation');
    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
})()

