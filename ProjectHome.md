|[![](http://psidev.info/files/psi.gif)](http://psidev.info/index.php?q=node/319)|
|:-------------------------------------------------------------------------------|


A Java API to the Proteomics Standards Initiative's mzIdentML format (version 1.1 - PSI stable version).

The mzIdentML data standard captures peptide and protein identification data, generated from mass spectrometry. For more information about mzIdentML, see the relevant googlecode repository: http://code.google.com/p/psi-pi/.

Another useful resource is the [10 minute guide to mzIdentML (PDF)](http://psi-pi.googlecode.com/files/TenMinuteGuideToImplementingMzidentml.pdf)

The API can be imported directly as a jar file to provide access to read and write functionality for mzIdentML. The API builds on top of JaxB capabilities, by providing an indexing scheme that allows random access to parts of the file. Under the wiki there are some code snippets showing example usage.

The API has been developed in collaboration between the PRIDE team at the EBI (led by Henning Hermjakob and Juan Antonio Vizcaino) and the post-genomic bioinformatics group at the University of Liverpool (led by Andy Jones).


The API is used as part of parsers for converting X!Tandem's XML file output and Omssa's OMX (XML) output to mzIdentML, accessible from: http://code.google.com/p/mzidentml-parsers/.


Using jMzIdentML
**Under Downloads - http://code.google.com/p/jmzidentml/downloads/list there is a zip file containing the main jar that can be imported directly into software.**

Under Wiki - http://code.google.com/p/jmzidentml/w/list, there are some example files showing the main functionality.

**jmzidentml Publication**
  * [Reisinger et al: Proteomics. 2012 Mar;12(6):790-4.](http://www.ncbi.nlm.nih.gov/pubmed/22539429).
  * If you use jmzidentml as part of a paper, please include this reference.

