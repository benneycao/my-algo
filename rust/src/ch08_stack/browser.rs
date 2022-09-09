struct Browser {
    history_stack: Vec<String>,
    forward_stack: Vec<String>,
}

impl Browser {
    pub fn new() -> Self {
        Self { history_stack: vec![], forward_stack: vec![] }
    }

    pub fn click_url(&mut self, url: &str) {
        self.history_stack.push(url.into());
        self.forward_stack.clear();
    }

    pub fn forward(&mut self) {
        match self.forward_stack.pop() {
            None => { println!("There is no page for to visited"); }
            Some(url) => {
                self.history_stack.push(url);
                self.show_page();
            }
        }
    }

    pub fn go_back(&mut self) {
        match self.history_stack.pop() {
            None => { println!("There is no page for to go back"); }
            Some(url) => {
                self.forward_stack.push(url);
                self.show_page();
            }
        }
    }
    fn show_page(&self) {
        println!("Now we in {:?} page", self.history_stack.last().unwrap());
    }
}

#[test]
fn test_browser() {
    let mut browser = Browser::new();
    browser.history_stack = vec![
        String::from("index"),
        String::from("home"),
        String::from("user"),
    ];
    browser.click_url("info");
    browser.go_back();
    browser.go_back();
    browser.forward();
}





















