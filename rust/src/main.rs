mod ch05_array;
mod ch08_stack;

fn main() {
    let i = 1;
    let j = 2;
    let mut res = 0;
    res = add(i, j);
}

fn add(x: i32, y: i32) -> i32 {
    let mut sum = 0;
    sum = x + y;
    sum
}
