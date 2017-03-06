/*
 *  Copyright 2013-2017 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.springframework.cloud.release;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 * @author Marcin Grzejszczak
 */
class PomReader {

	/**
	 * Returns a parsed POM
	 */
	Model readPom(File pom) {
		try(Reader reader = new FileReader(pom)) {
			MavenXpp3Reader xpp3Reader = new MavenXpp3Reader();
			return xpp3Reader.read(reader);
		}
		catch (XmlPullParserException | IOException e) {
			throw new IllegalStateException("Failed to read file", e);
		}
	}
}
