pub struct StringStack {
    size: usize,
    capacity: usize,
    // TODO 用自己的实现的简单 Vec 来代替rust 提供的
    element: Vec<String>,
}

impl StringStack {
    fn new(capacity: usize) -> Self {
        Self { size: 0, capacity, element: vec![] }
    }
    fn pop(&mut self) -> Option<String> {
        let option = self.element.pop();
        match option {
            None => {}
            Some(_) => { self.size -= 1; }
        };
        option
    }
    fn push(&mut self, v: &str) -> bool {
        if self.size == self.capacity {
            false
        } else {
            self.element.push(v.to_string());
            self.size +=1;
            true
        }
    }
    fn print_stack(&self) {
        for i in 0..self.size {
            println!("{:?}", &self.element[i]);
        }
    }
}

#[test]
fn test_stack() {
    let mut x = StringStack::new(5);
    x.push("1");
    x.push("2");
    x.push("3");
    x.push("4");
    x.push("5");
    x.push("6");
    x.pop();
    x.push("6");
    x.print_stack();
    
}

