package com.sample;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;

public class ProcessMain {

	public static final void main(String[] args) throws Exception {
		
		System.out.println("Start.");

		// load up the knowledge base
		KnowledgeBase kbase = readKnowledgeBase();
		final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		
		// init process instances
		for(int i=1;i<=10;i++){			
		
		// load data	
		Person person = null;
		Request request = null;
		
		switch (i) {
        case 1:  person = new Person("Person "+i,40,10,false); request = new Request(i,-40,person);	
                 break;
        case 2:  person = new Person("Person "+i,200,45,true); request = new Request(i,52,person);
                 break;
        case 3:  person = new Person("Person "+i,100,50,false); request = new Request(i,50,person);
                 break;
        case 4:  person = new Person("Person "+i,100,51,false); request = new Request(i,50,person);
                 break;
        case 5:  person = new Person("Person "+i,90,60,false); request = new Request(i,99,person);
                 break;
        case 6:  person = new Person("Person "+i,200,80,false); request = new Request(i,150,person);
                 break;
        case 7:  person = new Person("Person "+i,200,81,false); request = new Request(i,155,person);
                 break;
        case 8:  person = new Person("Person "+i,100,85,false); request = new Request(i,200,person);
                 break;
        case 9:  person = new Person("Person "+i,100,85,true); request = new Request(i,200,person);
                 break;
        case 10: person = new Person("Person "+i,-10,90,true); request = new Request(i,200,person);
                 break;
        default: break;
		}		
		
		// insert objects into session
		ksession.insert(person);
		ksession.insert(request);
		
		// save data for easier access in a HashMap		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("person", person);
	    params.put("request", request);
	    
	    // start process
		ProcessInstance pinstance = (ProcessInstance) ksession.startProcess("com.sample.bpmn.hello",params);
		ksession.insert(pinstance);
		ksession.fireAllRules(); 
		
		// test isValid statement
		//System.out.println("Test: is request valid? " +request.isValid());
		System.out.println("///////");	

		}
		
								
		
		System.out.println("End.");

	
	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("simple-rule.drl"), ResourceType.DRL);
		kbuilder.add(ResourceFactory.newClassPathResource("simple.bpmn"), ResourceType.BPMN2);
		
		return kbuilder.newKnowledgeBase();
	}
	
}