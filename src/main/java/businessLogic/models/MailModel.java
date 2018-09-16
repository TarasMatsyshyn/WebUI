package businessLogic.models;

public class MailModel {

    private String[] recipients;
    private String subject;
    private String messageBody;

    public MailModel(String[] recipients, String subject, String messageBody) {
        this.recipients = recipients;
        this.subject = subject;
        this.messageBody = messageBody;
    }

    public MailModel(String[] recipients, String messageBody) {
        this.recipients = recipients;
        this.messageBody = messageBody;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public void setRecipients(String[] recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getRecipientsString() {
        String result = "";
        for (int i = 0; i < recipients.length; i++) {
            result += String.format("%s ", recipients[i]);
        }
        return result;
    }
}
