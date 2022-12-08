# Project Title Goes Here

Info about your project goes here

// Create a Map to store the grid locations
Map<String, Integer> grid = new HashMap<>();

// Loop through the rows and columns to create the grid
for (int row = 1; row <= 5; row++) {
  for (int col = 1; col <= 5; col++) {
    // Use the row and column values to create the key for the grid location
    String key = "(" + row + "," + col + ")";
    
    // Set the value of the grid location to 0
    grid.put(key, 0);
  }
}

// Get the list of keys from the Map
List<String> keys = new ArrayList<>(grid.keySet());

// Loop through the keys to get the square locations
for (String key : keys) {
  // Split the key to get the row and column values
  String[] parts = key.split(",");
  int row = Integer.parseInt(parts[0]);
  int col = Integer.parseInt(parts[1]);
  
  // Use the row and column values to calculate the x and y coordinates
  // of the square on the canvas
  int x = col * SQUARE_SIZE;
  int y = row * SQUARE_SIZE;
  
  // Add a square to the canvas at the specified location
  canvas.add(new Rectangle(x, y, SQUARE_SIZE, SQUARE_SIZE));
}

