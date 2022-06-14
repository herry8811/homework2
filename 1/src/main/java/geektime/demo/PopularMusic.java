package geektime.demo;

import org.springframework.stereotype.Component;

@Component("popularMusic")
public class PopularMusic implements CompactDisc {
    @Override
    public void play() {
        System.out.println("play pop music");
    }
}

