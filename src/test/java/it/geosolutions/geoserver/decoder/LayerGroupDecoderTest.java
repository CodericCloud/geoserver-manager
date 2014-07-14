package it.geosolutions.geoserver.decoder;

import it.geosolutions.geoserver.rest.decoder.RESTLayerGroup;
import it.geosolutions.geoserver.rest.decoder.RESTStyleList;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * @author nmandery
 *
 */
public class LayerGroupDecoderTest {
	
	RESTLayerGroup layergroup;
	
	@Before
	public void setUp() throws IOException{
		File layerFile = new ClassPathResource("testdata/layergroupTigerNy.xml").getFile();
	    String layerString = FileUtils.readFileToString(layerFile);
	    layergroup = RESTLayerGroup.build(layerString);
	}


	@Test
	public void testName() {
		Assert.assertEquals("tiger-ny", layergroup.getName());
	}

	
	@Test
	public void testStyles() {
		RESTStyleList styles = layergroup.getStyles();
		Assert.assertTrue(styles != null);
		Assert.assertTrue(styles.size() == 4);
		Assert.assertEquals("giant_polygon", styles.get(0).getName());
		Assert.assertEquals("poly_landmarks", styles.get(1).getName());
	}
	
	
}
