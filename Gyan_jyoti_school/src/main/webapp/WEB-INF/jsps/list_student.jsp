  <h1>List of All Students</h1>
<button id="loadStudentsBtn">Load All Students</button>

<table id="studentTable" style="display:none; border: 1px solid black;">
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
    function loadStudents() {
        fetch('/listStudent') 
            .then(response => response.json())  
            .then(data => {
                console.log('Fetched Students:', data);

                const table = document.getElementById('studentTable');
                const tableBody = document.getElementById('studentTableBody');

                tableBody.innerHTML = ''; // Clear previous rows

                data.forEach(student => {
                    const row = document.createElement('tr');

                    // Create cells for each property
                    row.appendChild(createCell(student.id));
                    row.appendChild(createCell(student.name));
                    row.appendChild(createCell(student.address));
                    row.appendChild(createCell(student.phone));
                    row.appendChild(createCell(student.email));
                    row.appendChild(createCell(student.fathersName));
                    row.appendChild(createCell(student.dob));
                    row.appendChild(createCell(student.classTeacherName));
                    row.appendChild(createCell(student.classTeacherId));
                    row.appendChild(createCell(student.className));

                    // Append the row to the table body
                    tableBody.appendChild(row);
                });

                // Make the table visible after the data is loaded
                table.style.display = 'table';
            })
            .catch(error => {
                console.error('Error fetching student data:', error);
            });
    }

    // Helper function to create a table cell
    function createCell(content) {
        const cell = document.createElement('td');
        cell.textContent = content;
        return cell;
    }

    // Event listener to trigger loading students when the button is clicked
    document.getElementById('loadStudentsBtn').addEventListener('click', loadStudents);
</script>
