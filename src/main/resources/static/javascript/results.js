$(document).ready(function () {
    // Remember last searched game in session storage, so it will persist on refresh
    let game = sessionStorage.getItem("game");

    // When user clicks Logout button, send the hidden form to Spring Security
    $("#logout-btn").on("click", function (event) {
        event.preventDefault();
        document.logoutForm.submit();
    });

    $("#results-div").empty();
    gameSearch(game);

    // When user searches for a game, save the input to a variable, save to session storage, and send user to results page
    $("#search-btn").on("click", function (event) {
        event.preventDefault();
        $("#results-div").empty();
        const userInput = $("#search-bar").val().trim();
        sessionStorage.setItem("game", userInput);
        window.location.href = "results";
    });

    function gameSearch(game) {
        const settings = {
            "async": true,
            "crossDomain": true,
            "url": `https://api.rawg.io/api/games?key=00ae136b87af4d27b508fe9826ca73c2&search=${game}`,
            "method": "GET"
        };

        $.ajax(settings).done(function (response) {
            console.log(response);

            for (let i = 0; i < 8; i++) {

                let platformsArr = [];
                if (response.results[i].platforms) {
                    response.results[i].platforms.forEach(function (platform) {
                        platformsArr.push(platform.platform.name);
                    });
                }
                let platformsList = platformsArr.join(", ");
                let gameId = response.results[i].id;
                console.log(gameId);

                const content = `
        <div class="text-center mb-3">
          <a href="/gamedetails/${gameId}" class="card game-card h-100 text-decoration-none">
            <img src=${response.results[i].background_image} alt="Game cover" class="rounded" height="220px">
            <div class="card-body pb-0">
                  <h5>
                        ${response.results[i].name}
                  </h5>
                  <ul class="list-group list-group-flush">
                        <li class="list-group-item">Release Date: ${response.results[i].released}</li>
                        <li class="list-group-item">Platforms: ${platformsList}</li>
                  </ul>
                  <div class="card-text d-flex justify-content-between">
                        <div class="hover-message">
                              <span class="fa-stack fa-1x">
                                    <i class="fa-solid fa-heart fa-stack-2x"></i>
                                    <span class="fa-stack-1x results-num">27</span>
                              </span>
                              <span class="hover-text">Favorites</span>
                        </div>
                        <div class="hover-message">
                              <span class="fa-stack fa-1x">
                                    <i class="fa-solid fa-comment fa-stack-2x"></i>
                                    <span class="fa-stack-1x results-num"
                                          style="color: black">15</span>
                              </span>
                              <span class="hover-text">Comments</span>
                        </div>
                  </div>
            </div>
          </a>
        </div>`;

                $("#results-div").append(content);
            }
        });
    }
});
