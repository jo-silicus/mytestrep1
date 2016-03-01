rd hps
Echo "hps directory removed"
md hps
Echo "hps directory created"
cd hps
md dfu
pause
cd..

cd dfu1\images
jar cvfM images.jar *.*
copy images.jar ..\..\hps\dfu

cd..\images1
jar cvfM images1.jar *.*
copy images1.jar ..\..\hps\dfu
cd..
cd..


cd careercue
pause
jar cvfM careercue.jar *.*
del vcc*.*
copy *.jar ..\hps

cd..\cfc1
del vcc*.*
jar cvfM cfc1.jar *.*
copy *.jar ..\hps

cd..\cfs1
del vcc*.*
jar cvfM cfs1.jar *.*
copy *.jar ..\hps
cd..\cft1
del vcc*.*
jar cvfM cft1.jar *.*
copy *.jar ..\hps
cd..\cfu1
del vcc*.*
jar cvfM cfu1.jar *.*
copy *.jar ..\hps
cd..\cmi1
del vcc*.*
jar cvfM cmi1.jar *.*
copy *.jar ..\hps
cd..\cmr1
del vcc*.*
jar cvfM cmr1.jar *.*
copy *.jar ..\hps
cd..\cmr2
del vcc*.*
jar cvfM cmr2.jar *.*
copy *.jar ..\hps
cd..\cmr3
del vcc*.*
jar cvfM cmr3.jar *.*
copy *.jar ..\hps
cd..\cmr4
del vcc*.*
jar cvfM cmr4.jar *.*
copy *.jar ..\hps
cd..\cms1
del vcc*.*
jar cvfM cms1.jar *.*
copy *.jar ..\hps
cd..\cms2
del vcc*.*
jar cvfM cms2.jar *.*
copy *.jar ..\hps
cd..\cms3
del vcc*.*
jar cvfM cms3.jar *.*
copy *.jar ..\hps
cd..\cmu1
del vcc*.*
jar cvfM cmu1.jar *.*
copy *.jar ..\hps
cd..\cmu2a
del vcc*.*
jar cvfM cmu2a.jar *.*
copy *.jar ..\hps
cd..\cmu2m
del vcc*.*
jar cvfM cmu2m.jar *.*
copy *.jar ..\hps
cd..\cmu2s
del vcc*.*
jar cvfM cmu2s.jar *.*
copy *.jar ..\hps
cd..\cmu3
del vcc*.*
jar cvfM cmu3.jar *.*
copy *.jar ..\hps
cd..\cmu3a
del vcc*.*
jar cvfM cmu3a.jar *.*
copy *.jar ..\hps
cd..\cmu3s
del vcc*.*
jar cvfM cmu3s.jar *.*
copy *.jar ..\hps
cd..\cmu3m
del vcc*.*
jar cvfM cmu3m.jar *.*
copy *.jar ..\hps
cd..\cmu4a
del vcc*.*
jar cvfM cmu4a.jar *.*
copy *.jar ..\hps
cd..\cmu4s
del vcc*.*
jar cvfM cmu4s.jar *.*
copy *.jar ..\hps
cd..\cmuk
del vcc*.*
jar cvfM cmuk.jar *.*
copy *.jar ..\hps
cd..\cmum1m
del vcc*.*
jar cvfM cmum1m.jar *.*
copy *.jar ..\hps
cd..\cmum2m
del vcc*.*
jar cvfM cmum2m.jar *.*
copy *.jar ..\hps
cd..\cmum3m
del vcc*.*
jar cvfM cmum3m.jar *.*
copy *.jar ..\hps
cd..\cobrand
del vcc*.*
jar cvfM cobrand.jar *.*
copy *.jar ..\hps
cd..\csr1
del vcc*.*
jar cvfM csr1.jar *.*
copy *.jar ..\hps
cd..\csr2
del vcc*.*
jar cvfM csr2.jar *.*
copy *.jar ..\hps
cd..\css1
del vcc*.*
jar cvfM css1.jar *.*
copy *.jar ..\hps
cd..\css2
del vcc*.*
jar cvfM css2.jar *.*
copy *.jar ..\hps
cd..\css3
del vcc*.*
jar cvfM css3.jar *.*
copy *.jar ..\hps
cd..\dialog
del vcc*.*
jar cvfM dialog.jar *.*
copy *.jar ..\hps
cd..\dsr1
del vcc*.*
jar cvfM dsr1.jar *.*
copy *.jar ..\hps
cd..\efc1
del vcc*.*
jar cvfM efc1.jar *.*
copy *.jar ..\hps
cd..\efu1
del vcc*.*
jar cvfM efu1.jar *.*
copy *.jar ..\hps
cd..\efu2
del vcc*.*
jar cvfM efu2.jar *.*
copy *.jar ..\hps
cd..\ems1
del vcc*.*
jar cvfM ems1.jar *.*
copy *.jar ..\hps
cd..\ems2
del vcc*.*
jar cvfM ems2.jar *.*
copy *.jar ..\hps
cd..\ems3
del vcc*.*
jar cvfM ems3.jar *.*
copy *.jar ..\hps
cd..\ems4
del vcc*.*
jar cvfM ems4.jar *.*
copy *.jar ..\hps
cd..\esc1
del vcc*.*
jar cvfM esc1.jar *.*
copy *.jar ..\hps
cd..\esi1
del vcc*.*
jar cvfM esi1.jar *.*
copy *.jar ..\hps
cd..\esr1
del vcc*.*
jar cvfM esr1.jar *.*
copy *.jar ..\hps
cd..\ess1
del vcc*.*
jar cvfM ess1.jar *.*
copy *.jar ..\hps
cd..\mfs1
del vcc*.*
jar cvfM mfs1.jar *.*
copy *.jar ..\hps
cd..\mfu1
del vcc*.*
jar cvfM mfu1.jar *.*
copy *.jar ..\hps
cd..\mssa1
del vcc*.*
jar cvfM mssa1.jar *.*
copy *.jar ..\hps
cd..\msua1
del vcc*.*
jar cvfM msua1.jar *.*
copy *.jar ..\hps
cd..\msuv1
del vcc*.*
jar cvfM msuv1.jar *.*
copy *.jar ..\hps
cd..\navig
del vcc*.*
jar cvfM navig.jar *.*
copy *.jar ..\hps
cd..\nmt1
del vcc*.*
jar cvfM nmt1.jar *.*
copy *.jar ..\hps
cd..\nsi1
del vcc*.*
jar cvfM nsi1.jar *.*
copy *.jar ..\hps
cd..\nss1
del vcc*.*
jar cvfM nss1.jar *.*
copy *.jar ..\hps
cd..\nst1a
del vcc*.*
jar cvfM nst1a.jar *.*
copy *.jar ..\hps
cd..\nst1b
del vcc*.*
jar cvfM nst1b.jar *.*
copy *.jar ..\hps
cd..\nst2a
del vcc*.*
jar cvfM nst2a.jar *.*
copy *.jar ..\hps
