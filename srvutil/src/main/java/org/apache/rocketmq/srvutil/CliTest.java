package org.apache.rocketmq.srvutil;

import org.apache.commons.cli.*;

/**
 * org.apache.commons.cli工具的使用
 *
 * @author haojiahong created on 2018/12/28
 */
public class CliTest {
    //运行时添加参数 -c china -t nothing
    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        // -t 第二个参数false表示不支持参数值
        options.addOption("t", false, "display current time");
        // -c 第二个参数true表示支持参数值
        options.addOption("c", true, "country code");
        /**
         * Posix类型的Parser
         * Posix命令行的格式为： -参数名 参数值
         */
        CommandLineParser parser = new PosixParser();
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("c")) {
            String countryCode = cmd.getOptionValue("c");
            System.out.println(countryCode);
        }
        if (cmd.hasOption("t")) {
            String countryCode = cmd.getOptionValue("t");
            System.out.println(countryCode);
        }
        // 打印帮助信息
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CliTest", options, true);
    }
}
