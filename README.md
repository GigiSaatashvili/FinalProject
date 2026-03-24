# Final Project - UI and API Automation Framework

## პროექტის აღწერა
ეს პროექტი წარმოადგენს QA Automation ფინალურ პროექტს, რომელიც აერთიანებს:
- Web UI ტესტირებას Selenium WebDriver-ის გამოყენებით
- API ტესტირებას Rest Assured-ის გამოყენებით

პროექტი აგებულია Java, Maven და TestNG ტექნოლოგიებზე.

## გამოყენებული ტექნოლოგიები
- Java
- Maven
- Selenium WebDriver
- TestNG
- Rest Assured
- ExtentReports
- Page Object Model (POM)
- PageFactory

## პროექტის სტრუქტურა
- `ui.base` - UI საბაზო კლასები
- `ui.pages` - Page Object კლასები
- `ui.tests` - UI ტესტები
- `ui.utils` - დამხმარე კლასები
- `api.base` - API საბაზო კლასები
- `api.tests` - API ტესტები

## კონფიგურაცია
პროექტი იყენებს `config.properties` ფაილს, სადაც ინახება:
- `browser`
- `baseUrl`
- `apiBaseUrl`

## გაშვების ინსტრუქცია
ტესტების გასაშვებად გამოიყენება ბრძანება:

```bash
mvn test

## ავტორი
[ Gigi ]
