package com.simplekafka.broker;

/**
 * Holds information about a broker in the SimpleKafka cluster
 */
public class SimpleKafkaBroker {
    private final int id;
    private final String host;
    private final int port;
    
    public SimpleKafkaBroker(int id, String host, int port) {
        this.id = id;
        this.host = host;
        this.port = port;
    }
    
    public int getId() {
        return id;
    }
    
    public String getHost() {
        return host;
    }
    
    public int getPort() {
        return port;
    }
    
    @Override
    public String toString() {
        return "BrokerInfo{id=" + id + ", host='" + host + "', port=" + port + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        SimpleKafkaBroker other = (SimpleKafkaBroker) obj;
        return id == other.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}