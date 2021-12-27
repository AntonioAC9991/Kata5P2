package controller;

import model.Histogram;
import view.MailHistogramBuilder;
import view.MailListReader;
import view.HistogramDisplay;
import model.Mail;
import java.util.ArrayList;
import java.util.List;

import view.MailListReaderBD;
import view.MailReader;

public class Main {
    private List<Mail> mailList;
    private Histogram<String> histo;
    private HistogramDisplay histogramDisplay;
    private String fileName;

    public Main(String fileName) {
        this.fileName = fileName;
    }
    public static void main(String[] args) {
        Main main = new Main("D:\\NetBeansApplications\\Kata4\\email.txt");
        main.execute();
    }

    private void input(){
        MailReader mr = new MailListReaderBD();
        mailList = mr.read(fileName);
    }

    private void process(){
        histo = MailHistogramBuilder.build(mailList);;
        histogramDisplay= new HistogramDisplay(histo);
    }

    private void output(){
        histogramDisplay.execute();
    }

    private void execute(){
        input();
        process();
        output();

    }
}