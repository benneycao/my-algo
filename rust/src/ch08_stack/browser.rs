struct Browser {
    history: Vec<String>,
    forward: Vec<String>,
}

impl Browser {
    pub fn new() -> Self {
        Self { history: vec![], forward: vec![] }
    }

    pub fn click_url(&mut self, url: &str) {
        self.history.push(url.into());
        self.forward.clear();
    }

    pub fn forward(&mut self) {
        match self.forward.pop() {
            None => { println!("There is no page for to visited"); }
            Some(url) => {
                self.history.push(url);
                self.show_page();
            }
        }
    }

    pub fn go_back(&mut self) {
        match self.history.pop() {
            None => { println!("There is no page for to go back"); }
            Some(url) => {
                self.forward.push(url);
                self.show_page();
            }
        }
    }
    fn show_page(&self) {
        println!("Now we in {:?} page", self.history.last().unwrap());
    }
}

#[test]
fn test_browser() {
    let mut browser = Browser::new();
    browser.history = vec![
        String::from("index"),
        String::from("home"),
        String::from("user"),
    ];
    browser.click_url("info");
    browser.go_back();
    browser.go_back();
    browser.forward();
}





















