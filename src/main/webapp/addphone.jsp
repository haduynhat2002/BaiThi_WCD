<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
</style>
<body>

<div class="w3-container">
    <h2>Input Card</h2>

    <div class="w3-card-4">
        <div class="w3-container w3-green">
            <h2>Input Form</h2>
        </div>

        <form action="/addphone" method="post"  class="w3-container">
            <p>
                <input class="w3-input" name="name" type="text">
                <label>Name</label></p>


            <select name="brand">
                <option value="Apple">Apple</option>
                <option value="Samsung">Samsung</option>
                <option value="Nokia">Nokia</option>
                <option value="Others">Others</option>
            </select>
            <label>Brand</label>
            <p>
                <input class="w3-input" name="price" type="text">
                <label>Price</label></p>
            <p>
                <input class="w3-input" name="description" type="text">
                <label>Description</label></p>
            <p>
                <input type="submit" value="add">
                <input type="reset" value="reset">
            </p>
        </form>
    </div>
</div>

</body>
</html>

