# StudentRegistrationForm
🟢 Components of the Form


1️⃣ Form Fields (User Inputs)

First Name
Last Name
Username
Password (Hidden for security)
Address
Contact Number


2️⃣ Submit Button

Sends the entered details to the StudentServlet.


3️⃣ Backend Processing (Servlet)

Takes the form data.
Connects to the MySQL database.
Runs an INSERT query to store the student's details.
If the query succeeds, redirects to welcome.jsp.
If it fails, shows "Registration Failed!" message.
