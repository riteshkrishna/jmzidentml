# Configuring the reference resolving mechanism #

References can be resolved either by iterating through the whole file or by means of configurations provided in _defaultMzIdentMLElement.cfg.xml_ file. The configuration file is located in  src/ main/ resources/ folder. The configurations are loaded at run-time, so the changes can be made without recompiling the code.

Since this configurtion file is packaged within the jmzidentml jar file and most users will want to use the packaged version of the library, the API supports the provision of an external configuration file. If a file called _MzIdentMLElement.cfg.xml_ is present on the classpath, then the API will use this file instead of the default file for it's configuration. This way the API can be conveniently configured without the need to repackage it's jar file.

There are total four parameters to configure reference resolving and caching behaviour - auto-resolving, caching, ID-mapping and Indexing. We can enable a particular behaviour for a class by setting the appropriate element to _true_. In this example, we have auto-resolve disabled for SpectrumIdentificationItem.

```
    <configurations>
        <autoRefResolving>false</autoRefResolving>
        <cached>false</cached>
        <clazz>uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationItem</clazz>
        <cvParamClass>uk.ac.ebi.jmzidml.model.mzidml.params.SpectrumIdentificationItemCvParam</cvParamClass>
        <idMapped>true</idMapped>
        <indexed>true</indexed>
        <refResolverClass>uk.ac.ebi.jmzidml.xml.jaxb.resolver.SpectrumIdentificationItemRefResolver</refResolverClass>
        <tagName>SpectrumIdentificationItem</tagName>
        <userParamClass>uk.ac.ebi.jmzidml.model.mzidml.params.SpectrumIdentificationItemUserParam</userParamClass>
        <xpath>/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem</xpath>
    </configurations>

```

To enable the auto-resolve in SpectrumIdentificationItem, we simple set the `<autoRefResolving>` to true.

```
    <configurations>
        <autoRefResolving>true</autoRefResolving>
        <cached>false</cached>
        <clazz>uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationItem</clazz>
        <cvParamClass>uk.ac.ebi.jmzidml.model.mzidml.params.SpectrumIdentificationItemCvParam</cvParamClass>
        <idMapped>true</idMapped>
        <indexed>true</indexed>
        <refResolverClass>uk.ac.ebi.jmzidml.xml.jaxb.resolver.SpectrumIdentificationItemRefResolver</refResolverClass>
        <tagName>SpectrumIdentificationItem</tagName>
        <userParamClass>uk.ac.ebi.jmzidml.model.mzidml.params.SpectrumIdentificationItemUserParam</userParamClass>
        <xpath>/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem</xpath>
    </configurations>
```

In case of ID-mapping and indexing, we will keep **both** idMapped and indexed to be true.

The values of _indexed_, _idMapped_ and _autoRefResolving_ are defined by the MzIdentMLElement enumeration in the source code. This enumeration loads its configuration from the configuration file discussed above.