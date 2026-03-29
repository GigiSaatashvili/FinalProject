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


Extent report გენერირდება მისამართზე:

`target/ExtentReport.html`

## გამოყენებული დიზაინ პატერნი
პროექტში გამოყენებულია:
- Page Object Model (POM)
- PageFactory

## მიმდინარე UI ტესტები
- მთავარი გვერდის გახსნის შემოწმება
- ლოგოს ხილვადობის შემოწმება
- საძიებო ველის ხილვადობის შემოწმება
- საძიებო ველში ტექსტის შეყვანის შემოწმება
- მთავარი გვერდის title-ის შემოწმება
- საძიებო ველის placeholder ტექსტის შემოწმება
- MacBook Neo კატეგორიის გვერდზე გადასვლის შემოწმება

## მიმდინარე API ტესტები
- `/products` endpoint აბრუნებს 200 სტატუს კოდს
- პროდუქტების სია ცარიელი არ არის
- არარსებული პროდუქტის მოთხოვნაზე ბრუნდება 400 სტატუს კოდი
- `/products` პასუხის content type არის JSON
- პირველი პროდუქტის title ველი ცარიელი არ არის

## რეპორტინგი
პროექტში გამოყენებულია ExtentReports.
ტესტების შედეგები ინახება HTML report-ის სახით.

## Test Listener
პროექტში გამოყენებულია TestNG Listener, რომელიც აკონტროლებს:
- ტესტის დაწყებას
- წარმატებით შესრულებას
- ჩავარდნას
- გამოტოვებას

ეს ინფორმაცია ავტომატურად გადადის Extent report-ში.

## ავტორი
Gigi Saatashvili
