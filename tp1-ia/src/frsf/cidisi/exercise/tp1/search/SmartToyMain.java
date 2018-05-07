package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class SmartToyMain {

    public static void main(String[] args) throws PrologConnectorException {
        SmartToy agent = new SmartToy();

        Casa environment = new Casa();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
