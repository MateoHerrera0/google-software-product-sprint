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
  // const quotes = [
  //   '“Do You Like Scary Movies?” - Scream', 
  //   '“Do You Want To Play A Game?” - Saw', 
  //   '“It Rubs The Lotion On Its Skin Or Else It Gets The Hose Again.” - The Silence Of The Lambs',
  //   '"Groovy" - Evil Dead II', '“Nobody trusts anybody now…and we\'re all very tired.” - The Thing', 
  //   '“It\'s Halloween; I guess everyone\'s entitled to one good scare.” - Halloween'
  // ];

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


