// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random quote to the page.
 */
async function addQuote() {

  const responseFromServer = await fetch('/quote');
  // The json() function returns an object that contains fields that we can
  // reference to create HTML.
  const quotes = await responseFromServer.json();
  console.log(quotes);
  
  // Pick a random quote.
  const chosenQuote = quotes[Math.floor(Math.random() * quotes.length)];
  // Add it to the page.
  const quoteContainer = document.getElementById('quote');
  quoteContainer.innerText = chosenQuote;
}


/**
 * Adds forum posts to forum
 */
async function addForumPosts() {

  const responseFromServer = await fetch('/get-posts');
  // The json() function returns an object that contains fields that we can
  // reference to create HTML.
  const posts = await responseFromServer.json();
  console.log(posts);

  const bootstrap = 'col-md-4 card me-md-4 mb-md-0 mb-4 p-3 rounded text-center';
  let textColor = ''
  let bg = ''
  
  // Add it to the page.
  const forumContainer = document.getElementById('forum-area');
  
  for (let i = 0; i < posts.length; i++) {
    const element = posts[i];
    let div = document.createElement('div');
    if (element.secret) {
      bg = ' bg-warning';
      textColor = ' text-light';
    } else {
      bg = ' bg-light';
      textColor = ' text-dark';
    }

    let tags = bootstrap + bg + textColor;
    div.setAttribute('class', tags);
    div.innerHTML = "<p>" + element.message + "<br>-" + element.firstName + " " + element.lastName + "</p>";
    forumContainer.appendChild(div);
  }
  
}
