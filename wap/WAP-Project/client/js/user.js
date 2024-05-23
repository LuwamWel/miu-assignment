document.getElementById('loginButton').addEventListener('click', function(event) {
    event.preventDefault();
    const username = document.getElementById('floatingInput').value;
    const password = document.getElementById('floatingPassword').value;
  
  
  
    fetch('http://localhost:3000/user', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ username, password })
    })
    .then(response => {
      
      if (!response.ok) {
        throw new Error('Invalid credentials');
      }
      return response.json();
    })
    .then(data => {
      if (data.token) {
        sessionStorage.setItem('token', data.token);
        window.location.href = '../views/index.html';
      } else {
        document.getElementById('error').innerText = 'Invalid username or password';
      }
    })
    .catch(error => {
      document.getElementById('error').innerText = 'Invalid username or password';
      console.error('Error:', error);
    });
  });