document.addEventListener('DOMContentLoaded', function() {
    const passwordInput = document.getElementById('password');
    const confirmPasswordInput = document.getElementById('confirm-password');
    const submitButton = document.querySelector('button[type="submit"]');
    const errorMessage = document.getElementById('error-message');

    confirmPasswordInput.addEventListener('input', function() {
        if (passwordInput.value === confirmPasswordInput.value) {
            confirmPasswordInput.setCustomValidity('');
            errorMessage.style.display = 'none';
        } else {
            confirmPasswordInput.setCustomValidity('Passwords must match');
        }
    });

    submitButton.addEventListener('click', function(event) {
        if (passwordInput.value !== confirmPasswordInput.value) {
            event.preventDefault(); // Prevent form submission
            confirmPasswordInput.setCustomValidity('Passwords must match');
            errorMessage.style.display = 'block';

            // Display message in popup for 2 seconds
            errorMessage.style.backgroundColor = '#011936FF';
            errorMessage.style.color = '#ED254EFF';
            errorMessage.style.position = 'fixed';
            errorMessage.style.top = '50%';
            errorMessage.style.left = '50%';
            errorMessage.style.transform = 'translate(-50%, -50%)';
            errorMessage.style.padding = '10px';
            errorMessage.style.borderRadius = '30px';
            errorMessage.style.zIndex = '9999';

            setTimeout(function() {
                errorMessage.style.display = 'none';
            }, 2000); // 2000 milliseconds = 2 seconds
        }
    });
});

