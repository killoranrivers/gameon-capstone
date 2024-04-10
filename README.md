# Game On

## How It Works
Search for reviews for your favorite video game!

## Technologies Used
* HTML5
* CSS3
* Javascript
* jQuery
* Bootstrap 5
* Java 17
* Thymeleaf
* Spring Boot

## Screenshots
![index](https://github.com/killoranrivers/gameon-capstone/assets/45656198/34aad3cd-e87c-47ea-b85d-af027eb9cade)
![search-results](https://github.com/killoranrivers/gameon-capstone/assets/45656198/beafbd5c-f6a5-4b04-b05d-18586df6950c)
![game-details](https://github.com/killoranrivers/gameon-capstone/assets/45656198/08588ca7-8cb2-43d8-aa5c-e18b76ba85f1)

## Issues
- gameSearch wasn't remembering search term after page redirect from index.html to results.html, even with the 2 pages sharing a JS file SOLUTION: Save user input on index.html to session storage, then retrieve after loading results.html
- When on gamedetails.html, search button in navbar not working... It's sending me to gamedetails/results instead of /results. SOLUTION: Click event for search button needed window.location.href to point to "/results" instead of "results"
- Couldn't access game title from ajax search and send it to my controller. SOLUTION: Include hidden input in "add comment" form, use jQuery to set its value after completing ajax call, then save the nested Game object into the Comment object
- Can't delete a comment without deleting its parent (User)
