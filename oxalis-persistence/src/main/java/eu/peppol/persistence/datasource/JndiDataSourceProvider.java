/*
 * Copyright 2010-2017 Norwegian Agency for Public Management and eGovernment (Difi)
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/community/eupl/og_page/eupl
 *
 * Unless required by applicable law or agreed to in
 * writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied.
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
 */

package eu.peppol.persistence.datasource;

import com.google.inject.Provider;
import eu.peppol.persistence.util.PersistenceConf;
import no.difi.oxalis.api.settings.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Provides an instance of {@link javax.sql.DataSource} using the configuration parameters found
 * in {@link Settings}, which is located in OXALIS_HOME.
 *
 * @author steinar
 *         Date: 18.04.13
 *         Time: 13:28
 * @author erlend
 */
public class JndiDataSourceProvider implements Provider<DataSource> {

    public static final Logger LOGGER = LoggerFactory.getLogger(JndiDataSourceProvider.class);

    private final Settings<PersistenceConf> settings;

    @Inject
    public JndiDataSourceProvider(Settings<PersistenceConf> settings) {
        this.settings = settings;
    }

    @Override
    public DataSource get() {
        String dataSourceJndiName = settings.getString(PersistenceConf.JDBC_CONNECTION_URI);

        LOGGER.debug("Obtaining data source from JNDI: {}", dataSourceJndiName);
        try {
            Context initCtx = new InitialContext();

            return (DataSource) initCtx.lookup(dataSourceJndiName);
        } catch (NamingException e) {
            throw new IllegalStateException(
                    String.format("Unable to obtain JNDI datasource from '%s'.", dataSourceJndiName), e);
        }
    }
}
