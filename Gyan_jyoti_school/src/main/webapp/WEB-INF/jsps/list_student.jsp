    <h1>List of All Students</h1>
    <button id="loadStudentsBtn">Load All Students</button>
    
    <table id="studentTable" style="display:none;">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Grade</th>
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

                  
                    tableBody.innerHTML = '';

                   
                    data.forEach(student => {
                        const row = document.createElement('tr');

                        // Create cells for ID, Name, and Grade
                        const idCell = document.createElement('td');
                        idCell.textContent = student.id;
                        row.appendChild(idCell);

                        const nameCell = document.createElement('td');
                        nameCell.textContent = student.name;
                        row.appendChild(nameCell);

                        const gradeCell = document.createElement('td');
                        gradeCell.textContent = student.grade;
                        row.appendChild(gradeCell);

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

        // Event listener to trigger loading students when the button is clicked
        document.getElementById('loadStudentsBtn').addEventListener('click', loadStudents);
    </script>