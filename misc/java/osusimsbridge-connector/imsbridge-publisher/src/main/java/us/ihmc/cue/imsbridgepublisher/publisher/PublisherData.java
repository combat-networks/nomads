package us.ihmc.cue.imsbridgepublisher.publisher;


import mil.dod.th.core.log.Logging;
import org.osgi.service.log.LogService;

import java.util.Optional;

public class PublisherData
{
    public PublisherData(){
        _federationCIDString = Optional.empty();
        _pubURL = "";
    }

    public String getHost () {
        return _host;
    }

    public void setHost (String host) {
        _host = host;
    }

    public int getPort () {
        return _port;
    }

    public void setPort (int port) {
        _port = port;
    }

    public Optional<String> getFederationCIDString () {
        return _federationCIDString;
    }

    public void setFederationCIDString (String federationCIDString) {
        if (federationCIDString == null){
            Logging.log(LogService.LOG_DEBUG, "Not setting federation client ID");
        }
        else {
            _federationCIDString = Optional.of("&cid=" + federationCIDString);
        }

        updatePubURL();
    }

    public String getPubURL () {
        return _pubURL;
    }

    public void setPubURL (String pubURL) {
        _pubURL = pubURL;
    }

    public void updatePubURL () {
        setPubURL("http://" + _host + ":" + _port + "/federation/publish?type=linguafranca" + _federationCIDString.orElse(""));
    }

    private String _host;
    private int _port;
    private Optional<String> _federationCIDString;
    private String _pubURL;
}