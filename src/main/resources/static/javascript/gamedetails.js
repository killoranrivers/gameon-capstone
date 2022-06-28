$(document).ready(function () {
    let gameId = window.location.href.substring(
        window.location.href.lastIndexOf("/") + 1);

    // When user clicks Logout button, send the hidden form to Spring Security
    $("#logout-btn").on("click", function (event) {
        event.preventDefault();
        document.logoutForm.submit();
    });

    gameSearch(gameId);

    // When user searches for a game, save the input to a variable, save to session storage, and send user to results page
    $("#search-btn").on("click", function (event) {
        event.preventDefault();
        const userInput = $("#search-bar").val().trim();
        sessionStorage.setItem("game", userInput);
        window.location.href = "/results";
    });

    function gameSearch(gameId) {
        const settings = {
            "async": true,
            "crossDomain": true,
            "url": `https://api.rawg.io/api/games/${gameId}?key=00ae136b87af4d27b508fe9826ca73c2`,
            "method": "GET"
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            const photo = response.background_image;
            const title = response.name;
            const score = response.metacritic;

            $(".detail-photo").attr("src", photo);
            $("#game-title").text(title);
            $("#score").text(score);
            $("#title").attr("value", title);
        });
    }
});
