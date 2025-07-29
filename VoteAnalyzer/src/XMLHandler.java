import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler
{
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private  HashMap<Voter, Integer> voterCounts;
    private Voter voter;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter"))
            {
                String name = attributes.getValue("name");
                Date date = birthDayFormat.parse(attributes.getValue("birthDay"));
                DBConnection.countVoter(name, birthDayFormat.format(date));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void endDocument() throws SAXException{
        try {
            DBConnection.executeMultiinsert();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("voter"))
        {
            voter = null;
        }
    }

    public void printDuplicatedVoters()
    {
        for(Voter voter : voterCounts.keySet())
        {
            int count = voterCounts.get(voter);
            if(count > 1)
            {
                System.out.println(voter.toString() + " - " + count);
            }
        }
    }
}
