package spring._init_shell.shell;


import org.jline.utils.AttributedStyle;
import org.jline.utils.AttributedString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;



@SpringBootApplication
public class ShellApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShellApplication.class, args);

	}

	static void writeStringToFile(String data, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file, false);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(data);
		bufferedWriter.flush();
		bufferedWriter.close();
		fileWriter.close();
	}


}

@Component
class CustomPromptProvider implements PromptProvider {

	@Override
	public AttributedString getPrompt() {
		return new AttributedString("PomBuilderX:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
	}


}
