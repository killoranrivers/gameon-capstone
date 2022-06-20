$(document).ready(function () {
    const regEx = new RegExp("[a-z0-9]+@[a-z]+.[a-z]{2,3}", "g");
    // Target email input for Sign In/Up so I can change the color
    const emailInput = $("#email-input");
    // Save signed-in status to variable
    let signedIn = sessionStorage.getItem("signedIn");
    // Remember last searched game in session storage, so it will persist on refresh
    let game = sessionStorage.getItem("game");

    // If
    if (sessionStorage.getItem("redirect") == true) {
        sessionStorage.setItem("redirect", "false");
        gameSearch(game);
    } else {
        $("#results-div").empty();
        gameSearch(game);
    }

    // Display Logout or Sign In/Up, depending on the user's login status
    renderLogin(signedIn);

    // Test email against the regex to make sure it fits the pattern. If so, signedIn status will be set to true and user will be redirected to the home page. If not, the input will turn red and the user will be alerted to enter a valid email.
    function validate(email) {
        if (regEx.test(email)) {
            sessionStorage.setItem("signedIn", "true");
            signedIn = sessionStorage.getItem("signedIn");
            window.location.href = "index";
            renderLogin(signedIn);
        } else {
            emailInput.removeClass("bg-black").addClass("bg-red");
            alert(`Please enter a valid email!`);
        }
    }

    // Check the session storage for login status
    function renderLogin(status) {
        if (status == "true") {
            $("#sign-in").html(`<a th:href="@{/}" id='logout-btn'>Logout</a>`);
        } else {
            $("#sign-in").html(
                `<div><a th:href="@{/signin}">Sign In</a></div>\
                 <div><a th:href="@{/signup}">Sign Up</a></div>`
            );
        }
    }

    // When signing in, save the user email input to a variable and send it to validate() as an argument
    $("#signin-btn").on("click", function (event) {
        event.preventDefault();
        let email = $("#email-input").val().trim();
        validate(email);
    });

    //When signing up, save the user email input to a variable and send it to validate() as an argument
    $("#signup-btn").on("click", function (event) {
        event.preventDefault();
        let email = $("#email-input").val().trim();
        validate(email);
    });

    // When logging out, change signedIn value to false, redirect to home page, and change Logout to Sign In/Up
    $("#logout-btn").on("click", function (event) {
        event.preventDefault();
        sessionStorage.setItem("signedIn", "false");
        window.location.href = "index";
        signedIn = sessionStorage.getItem("signedIn");
        renderLogin(signedIn);
    });

    // When user searches for a game, save the input to a variable, save to session storage, and send user to results page
    $("#search-btn").on("click", function (event) {
        event.preventDefault();
        $("#results-div").empty();
        const userInput = $("#search-bar").val().trim();
        sessionStorage.setItem("game", userInput);
        gameSearch(userInput);
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

                const content = `
        <div class="text-center mb-3">
          <a th:href="@{/gamedetails}" class="card game-card h-100 text-decoration-none">
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
