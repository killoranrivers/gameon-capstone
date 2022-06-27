$(document).ready(function () {
    // When user clicks Logout button, send the hidden form to Spring Security
    $("#logout-btn").on("click", function (event) {
        event.preventDefault();
        document.logoutForm.submit();
    });


    // When user searches for a game, save the input to a variable, save to session storage, and send user to results page
    $("#search-btn").on("click", function (event) {
        event.preventDefault();
        let userInput = $("#search-bar").val().trim();
        sessionStorage.setItem("game", userInput);
        window.location.href = "results";
    });
});
