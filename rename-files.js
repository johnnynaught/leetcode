const fs = require('fs');
const path = require('path');

const dir = '/Users/johnnyxue/Desktop/Johnny Xue/Projects/leetcode';
const files = fs.readdirSync(dir);

files.forEach(file => {
  const match = file.match(/^(\d+)\.(.*)/);
  if (match) {
    const id = match[1];
    const paddedId = id.padStart(4, '0');
    const newName = `${paddedId}.${match[2]}`;
    
    if (file !== newName) {
      fs.renameSync(path.join(dir, file), path.join(dir, newName));
      console.log(`${file} → ${newName}`);
    }
  }
});
