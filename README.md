# DinnerDash!
## Built during IC Hack 2020
Have you ever lamented the fact that despite having a luxurious kitchen full of quality ingredients and reliable appliances, only to realize that you do not have the time to cook, and therefore causing your daily meals to be lackluster? Fret no more, for we have the perfect app for you!
Introducing DinnerDash, the interactive app that allows you to cook more than one new dish concurrently within a short preparation time! 

## Inspiration
- Inspired by the increasingly prevalent urge to taste new home-cooked food despite having insufficient cooking time and knowledge
-	Creatively customized to optimize cooking by simultaneously preparing different recipes

## What it does
-	Sweeps a wide dataset of cooking recipes from multiple online sources
-	Compares your input with our comprehensive algorithms to pick out the most suitable and efficient recipes for you
-	Deconstructs your chosen recipes into individual steps
- By having a better understanding of the time taken for these steps for better prioritizing and "pipelining"!
- _(You can now chop your onions for dish A while roasting your chicken for dish B in the oven!)_

## How we built it
-	We created a JSON database using Excel VBA of nearly 10,000 online recipes using our customized web scraper tools built from Python.
-	Lexed the ingredients and instructions from our database with Java so we can extract the quantity required and the amount of time spent for each step respectively
-	Identify processes that do not require attention (e.g. oven baking) using Java and thus make the decision to perform multiple steps from other recipes at the same time
-	Complex Java-centered algorithm to link the back-end to the front-end
-	Interactive front-end user interface for android using Java Android Studio

## Challenges we faced
-	We attempted to utilise Antlr, Flex, and other lexing and parsing tools. However, we concluded that a custom-made lexer with java would be the best solution for our current situation
- This led to a lot of time being consumed on deciphering and debugging our lexer.
-	Secondly, we had no prior experience with front-end android app creation, and we had to learn and improve during the duration of the hackathon
-	Also, since our JSON database was created from Excel VBA, we have to ensure all syntax to be correct
-	In addition, JSON is more suitable for Javascript programming but we were using Java instead, leading to more loss of time. 
-	Almost every member in our team codes in different languages, such as Python, C++ and Java. As such, a lot of translation was needed to ensure that the final code was running smoothly. 
- The connection from the back-end to the front-end was extremely challenging and took up quite a fair amount of time.

## Accomplishments that we're proud of
-	Despite all of the above challenges, manage to finish the project and (hopefully) everything is running smoothly!
-	A work-life balance was well established during the hackathon, and we were definitely not nerds nor loafers!
-	This project gave us the opportunity to learn other languages, and impart our understanding of our native language to them as well

## What we learned
-	Many more languages
-	Collaboration and teamwork
-	How to realise an idea from scratch

## What's next for DinnerDash!
-	Given a grocery list, plan meals for the week in advance:
     o	Enhance variety: customize based on lifestyles and diet preferences
-	Suggest meals for different numbers of people:
     o	Machine learning to know how many portions and everyone’s individual preferences
