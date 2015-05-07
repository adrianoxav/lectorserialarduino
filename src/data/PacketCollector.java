/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import GUI.Ventana;
import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.AtCommand;
import com.rapplogic.xbee.api.AtCommandResponse;
import com.rapplogic.xbee.api.PacketListener;
import com.rapplogic.xbee.api.RemoteAtRequest;
import com.rapplogic.xbee.api.RemoteAtResponse;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.zigbee.ZNetRxIoSampleResponse;
import com.rapplogic.xbee.api.zigbee.ZNetRxResponse;
import com.rapplogic.xbee.util.ByteUtils;

/**
 *
 * @author adriano.pinargote
 */
public class PacketCollector implements PacketListener{

    private Ventana frame; 
    public void setGUI(Ventana frame){
        this.frame= frame;
        
    
    }
    
    @Override
    public void processResponse(XBeeResponse xbr) {
        
        int info[]=xbr.getProcessedPacketBytes();
        //ventana.getData(info);
        String tipo = ApiDecide(xbr);
        ZNetRxResponse net = (ZNetRxResponse) xbr;
        
        if(frame.on.isSelected())
        {   
            //frame.pantalla.append("DATA :" + ByteUtils.toBase10(net.getData())+"\n" );
            frame.pantalla.append("Tipo de Paquete: " + tipo + "    Adrress: " + (net.getRemoteAddress64().getAddress()) + "    Data: " + ByteUtils.toBase10(net.getData())+"\n");
        }
    }
    
    
public String ApiDecide(XBeeResponse x){
    String g = new String(" ");
    if(x.getApiId()==ApiId.AT_COMMAND)
        return g="AT_COMMAND";
    
    if(x.getApiId()==ApiId.AT_COMMAND_QUEUE)
        return g="AT_COMMAND_QUEUE";
    
    if(x.getApiId()==ApiId.AT_RESPONSE)
        return g="AT_RESPONSE";
    
    if(x.getApiId()==ApiId.ERROR_RESPONSE)
        return g="ERROR_RESPONSE";
    
    if(x.getApiId()==ApiId.MODEM_STATUS_RESPONSE)
        return g="MODEM_STATUS_RESPONSE";
    
    if(x.getApiId()==ApiId.REMOTE_AT_REQUEST)
        return g="REMOTE_AT_REQUEST";
    
    if(x.getApiId()==ApiId.REMOTE_AT_RESPONSE)
        return g="REMOTE_AT_RESPONSE";
    
    if(x.getApiId()==ApiId.RX_16_IO_RESPONSE)
        return g="RX_16_IO_RESPONSE";
    
    if(x.getApiId()==ApiId.RX_16_RESPONSE)
        return g="RX_16_RESPONSE";
    
    if(x.getApiId()==ApiId.RX_64_IO_RESPONSE)
        return g="RX_64_IO_RESPONSE";
    
    if(x.getApiId()==ApiId.RX_64_RESPONSE)
        return g="RX_64_RESPONSE";
    
    if(x.getApiId()==ApiId.TX_REQUEST_16)
        return g="TX_REQUEST_16";
    
    if(x.getApiId()==ApiId.TX_REQUEST_64)
        return g="TX_REQUEST_64";
    
    if(x.getApiId()==ApiId.TX_STATUS_RESPONSE)
        return g="TX_STATUS_RESPONSE";
    
    if(x.getApiId()==ApiId.UNKNOWN)
        return g="UNKNOWN";
    
    if(x.getApiId()==ApiId.ZNET_EXPLICIT_RX_RESPONSE)
        return g="ZNET_EXPLICIT_RX_RESPONSE";
    
    if(x.getApiId()==ApiId.ZNET_EXPLICIT_TX_REQUEST)
        return g="ZNET_EXPLICIT_TX_REQUEST";
    
    if(x.getApiId()==ApiId.ZNET_IO_NODE_IDENTIFIER_RESPONSE)
        return g="ZNET_IO_NODE_IDENTIFIER_RESPONSE";
    
    if(x.getApiId()==ApiId.ZNET_IO_SAMPLE_RESPONSE)
        return g="ZNET_IO_SAMPLE_RESPONSE";
    
    if(x.getApiId()==ApiId.ZNET_RX_RESPONSE)
        return g="ZNET_RX_RESPONSE";
    
    if(x.getApiId()==ApiId.ZNET_TX_REQUEST)
        return g="ZNET_TX_REQUEST";
    
    if(x.getApiId()==ApiId.ZNET_TX_STATUS_RESPONSE)
        return g="ZNET_TX_STATUS_RESPONSE";
        
    return null;
    
    }
    
}

