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

package no.difi.oxalis.commons.filesystem;

import no.difi.oxalis.api.settings.DefaultValue;
import no.difi.oxalis.api.settings.Nullable;
import no.difi.oxalis.api.settings.Path;
import no.difi.oxalis.api.settings.Title;

/**
 * @author erlend
 */
@Title("File system")
public enum FileSystemConf {

    @Path("oxalis.path.conf")
    @DefaultValue("")
    CONF,

    @Path("oxalis.path.inbound")
    @DefaultValue("inbound")
    INBOUND,

    @Path("oxalis.path.plugin")
    @Nullable
    PLUGIN,

}
