<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>
    <style>
        /* Body styling for background gradient */
        body {
            margin: 0;
            height: 100vh;
            background: linear-gradient(to bottom, #1e3c72, #2a5298); /* Blue gradient */
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            text-align: center;
        }

        /* Container for the error message */
        .error-container {
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.6); /* Semi-transparent background */
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
        }

        .error-container h1 {
            font-size: 3em;
            margin-bottom: 10px;
        }

        .error-container p {
            font-size: 1.5em;
        }

        /* Style the button to go back */
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #f44336; /* Red button */
            color: white;
            font-size: 1.2em;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>

    <div class="error-container">
        <h1>404 - Page Not Found</h1>
        <p>Sorry, the page you are looking for does not exist.</p>
        <a href="/home" class="btn">Go to Home</a>
    </div>

</body>
</html>
