
document.addEventListener("DOMContentLoaded", function () {
    const headerRow = document.getElementById("dynamicHeaderRow");
    const dataRows = document.querySelectorAll(".data-row");

    const allKeys = new Set();

    // Step 1: Collect all unique dynamic field keys from each row
    dataRows.forEach(row => {
        const jsonData = row.getAttribute("data-json");
        if (jsonData) {
            try {
                const obj = JSON.parse(jsonData);
                Object.keys(obj).forEach(key => allKeys.add(key));
            } catch (e) {
                console.error("Invalid JSON:", jsonData);
            }
        }
    });

    // Step 2: Add header columns for each dynamic key
    const keysArray = Array.from(allKeys);
    const dynamicIndex = 5; // Adjust as needed to place dynamic columns before images
    keysArray.forEach((key, i) => {
        const th = document.createElement("th");
        th.textContent = key;
        headerRow.insertBefore(th, headerRow.children[dynamicIndex + i]);
    });

    // Step 3: Add each dynamic field value as a <td> in each row
    dataRows.forEach(row => {
        const jsonData = row.getAttribute("data-json");
        let obj = {};
        try {
            obj = JSON.parse(jsonData);
        } catch (e) {}

        keysArray.forEach((key, i) => {
            const td = document.createElement("td");
            td.textContent = obj[key] || "";
            row.insertBefore(td, row.children[dynamicIndex + i]);
        });

        // Remove placeholder cell if it exists
        const placeholder = row.querySelector(".dynamic-fields-placeholder");
        if (placeholder) {
            placeholder.remove();
        }
    });
});

