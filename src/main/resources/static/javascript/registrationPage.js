document.addEventListener('DOMContentLoaded', function () {
    const passwordInput = document.getElementById('password');
    const confirmPasswordInput = document.getElementById('confirm-password');
    const nameInput = document.getElementById('name');
    const emailInput = document.getElementById('email');
    const submitButton = document.querySelector('button[type="submit"]');
    const errorMessage = document.getElementById('error-message');

    confirmPasswordInput.addEventListener('input', function () {
        if (passwordInput.value === confirmPasswordInput.value) {
            confirmPasswordInput.setCustomValidity('');
            errorMessage.style.display = 'none';
        } else {
            confirmPasswordInput.setCustomValidity('Passwords must match');
        }
    });

    submitButton.addEventListener('click', function (event) {
        event.preventDefault();

        // Validate name
        if (nameInput.value.length > 15) {
            nameInput.setCustomValidity('Name must not exceed 15 characters');
            showError('Name must not exceed 15 characters');
            return;
        } else {
            nameInput.setCustomValidity('');
        }

        // Validate email
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(emailInput.value)) {
            emailInput.setCustomValidity('Invalid email address');
            showError('Invalid email address');
            return;
        } else {
            emailInput.setCustomValidity('');
        }

        // Validate password
        const password = passwordInput.value;
        const hasNumber = /\d/.test(password);
        const hasLowercase = /[a-z]/.test(password);
        const hasUppercase = /[A-Z]/.test(password);
        if (password.length > 20) {
            passwordInput.setCustomValidity('Password must not exceed 20 characters');
            showError('Password must not exceed 20 characters');
            return;
        } else if (!hasNumber || !hasLowercase || !hasUppercase) {
            passwordInput.setCustomValidity('Password must contain at least one number, one lowercase letter, and one uppercase letter');
            showError('Password must contain at least one number, one lowercase letter, and one uppercase letter');
            return;
        } else {
            passwordInput.setCustomValidity('');
        }

        // Validate confirm password
        if (passwordInput.value !== confirmPasswordInput.value) {
            confirmPasswordInput.setCustomValidity('Passwords must match');
            showError('Passwords must match');
            return;
        } else {
            confirmPasswordInput.setCustomValidity('');
        }

        // If all validations pass, submit the form
        event.target.closest('form').submit();
    });

    function showError(message) {
        errorMessage.textContent = message;
        errorMessage.style.display = 'block';

        setTimeout(function () {
            errorMessage.style.display = 'none';
        }, 3000);
    }
});
