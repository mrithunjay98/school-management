<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #ff7e5f, #feb47b);
            color: #333;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #fff;
        }

        button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
            overflow: hidden;
        }

        thead {
            background-color: #007BFF;
            color: #fff;
        }

        th, td {
            padding: 5px 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tbody tr:nth-child(odd) {
            background-color: #fdfdfd;
        }

        tbody tr:hover {
            background-color: #f1f1f1;
            cursor: pointer;
        }

        th {
            text-transform: uppercase;
            letter-spacing: 0.1em;
        }
    </style>
</head>
<body>

<h1 style="color:black">List of All Students</h1>


<table id="studentTable" style="display:none;">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Father's Name</th>
            <th>Date of Birth</th>
            <th>Class Teacher Name</th>
            <th>Class Teacher ID</th>
            <th>Class Name</th>
        </tr>
    </thead>
    <tbody id="studentTableBody">
        <!-- Students will be added here dynamically -->
    </tbody>
</table>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        loadStudents(); // Call loadStudents when the page is fully loaded
    });

    function loadStudents() {
        const table = document.getElementById('studentTable');
        const tableBody = document.getElementById('studentTableBody');
        const loadingIndicator = document.getElementById('loadingIndicator');
        
        // Show loading indicator
        if (loadingIndicator) loadingIndicator.style.display = 'block';

        fetch(`/listAllStudents`) // Use the correct `id` value in your application
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('Fetched Students:', data);

                tableBody.innerHTML = ''; // Clear previous rows

                if (data.length === 0) {
                    // Show a message if no students are returned
                    const row = document.createElement('tr');
                    const cell = document.createElement('td');
                    cell.colSpan = 10; // Adjust according to your table's column count
                    cell.textContent = 'No students found.';
                    cell.style.textAlign = 'center';
                    row.appendChild(cell);
                    tableBody.appendChild(row);
                } else {
                    // Populate the table with student data
                    data.forEach(student => {
                        const row = document.createElement('tr');

                        row.appendChild(createCell(student.id));
                        row.appendChild(createCell(student.name || 'N/A'));
                        row.appendChild(createCell(student.address || 'N/A'));
                        row.appendChild(createCell(student.phone || 'N/A'));
                        row.appendChild(createCell(student.email || 'N/A'));
                        row.appendChild(createCell(student.fathersName || 'N/A'));
                        row.appendChild(createCell(student.dob || 'N/A'));
                        row.appendChild(createCell(student.classTeacherName || 'N/A'));
                        row.appendChild(createCell(student.classTeacherId || 'N/A'));
                        row.appendChild(createCell(student.className || 'N/A'));

                        tableBody.appendChild(row);
                    });
                }

                table.style.display = 'table'; // Ensure table is visible
            })
            .catch(error => {
                console.error('Error fetching student data:', error);
                
                // Display error message in the table
                tableBody.innerHTML = '';
                const row = document.createElement('tr');
                const cell = document.createElement('td');
                cell.colSpan = 10; // Adjust according to your table's column count
                cell.textContent = 'An error occurred while fetching student data.';
                cell.style.textAlign = 'center';
                row.appendChild(cell);
                tableBody.appendChild(row);
            })
            .finally(() => {
                // Hide loading indicator
                if (loadingIndicator) loadingIndicator.style.display = 'none';
            });
    }

    // Helper function to create a table cell
    function createCell(content) {
        const cell = document.createElement('td');
        cell.textContent = content;
        return cell;
    }
</script>


</body>
</html>
