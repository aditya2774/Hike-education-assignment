const states = {
    "Karnataka": ["Bangalore", "Mysore", "Mangalore"],
    "Maharashtra": ["Mumbai", "Pune", "Nagpur"],
    "Tamil Nadu": ["Chennai", "Coimbatore", "Madurai"],
    "Delhi": ["New Delhi", "Gurgaon", "Noida"]
};

document.addEventListener("DOMContentLoaded", () => {
    const stateSelect = document.getElementById("state");
    const citySelect = document.getElementById("city");

    // Populate states dropdown
    for (let state in states) {
        const option = document.createElement("option");
        option.value = state;
        option.textContent = state;
        stateSelect.appendChild(option);
    }

    // Update cities dropdown when state changes
    stateSelect.addEventListener("change", () => {
        citySelect.innerHTML = '<option value="">Select City</option>'; // Clear previous options
        const selectedState = stateSelect.value;

        if (selectedState) {
            const cities = states[selectedState];
            for (let city of cities) {
                const option = document.createElement("option");
                option.value = city;
                option.textContent = city;
                citySelect.appendChild(option);
            }
        }
    });
});
document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("enquiryForm");

    form.addEventListener("submit", async (event) => {
        event.preventDefault(); // Prevent form submission

        // Fetch individual form field values
        const name = document.getElementById("name").value;
        const countryCode = document.getElementById("country-code").value;
        const mobile = document.getElementById("mobile").value;
        const email = document.getElementById("email").value;
        const state = document.getElementById("state").value;
        const city = document.getElementById("city").value;
        const program = document.getElementById("program").value;
        const elective = document.getElementById("elective").value;
        const agreement = document.getElementById("agreement").checked;

        // Create payload object
        const formData = {
            name,
            countryCode,
            mobile,
            email,
            state,
            city,
            program,
            elective,
            agreement
        };

        console.log(formData)
        try {
            const response = await fetch("http://127.0.0.1:8080/api/savedata", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(formData)
            });
        
            if (!response.ok) {
                error = {};
                response.json().then(result => {
                    for(const property in result){
                        alert(`${property} : ${result[property]}`)
                    }
                })

                
            }else{
                const contentType = response.headers.get("content-type");
                if (contentType && contentType.includes("application/json")) {
                    const data = await response.json();
                    alert("Data saved successfully: " + data.message);
                    form.reset(); // Reset form after successful submission
                } else {
                    // Handle empty or unexpected response
                    alert("Data saved successfully."); // or show a generic success message
                    form.reset();
                }
            }
        

        } catch (error) {

            // console.error("Error:", error);
            // for(const property in error){
            //     console.log(`${property}: ${error[property]}`)
            // }
            console.log(error.error)
        }
        
    });
});
