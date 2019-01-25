mkdir logs
echo %date% %time% ========================================================================================================================> logs/result.log
echo %date% %time%  [Start]                                                                                                                >> logs/result.log
echo %date% %time%                                                                                                                         >> logs/result.log
echo %date% %time%  Initialize                                                                                                             >> logs/result.log

rem the following line means sleeping 1 seconds
ping 127.0.0.1 -n 1 > nul

echo %date% %time% ========================================================================================================================>> logs/result.log
echo %date% %time%  [Step1]                                                                                                                >> logs/result.log
echo %date% %time%                                                                                                                         >> logs/result.log
echo %date% %time%  Export LDIF file from LDAP server                                                                                      >> logs/result.log

ping 127.0.0.1 -n 1 > nul

echo %date% %time% ========================================================================================================================>> logs/result.log
echo %date% %time%  [Step2]                                                                                                                >> logs/result.log
echo %date% %time%                                                                                                                         >> logs/result.log
echo %date% %time%  Create CSV file from LDIF file                                                                                         >> logs/result.log

ping 127.0.0.1 -n 1 > nul

echo %date% %time% ========================================================================================================================>> logs/result.log
echo %date% %time%  [Step3]                                                                                                                >> logs/result.log
echo %date% %time%                                                                                                                         >> logs/result.log
echo %date% %time%  Remove LDIF file                                                                                                       >> logs/result.log

ping 127.0.0.1 -n 1 > nul

echo %date% %time% ========================================================================================================================>> logs/result.log
echo %date% %time%  [Step4]                                                                                                                >> logs/result.log
echo %date% %time%                                                                                                                         >> logs/result.log
echo %date% %time%  Pre-Import Processing                                                                                                  >> logs/result.log

ping 127.0.0.1 -n 1 > nul

echo %date% %time% ========================================================================================================================>> logs/result.log
echo %date% %time%  [Step5]                                                                                                                >> logs/result.log
echo %date% %time%                                                                                                                         >> logs/result.log
echo %date% %time%  Import CSV to Database (This will take a long time, about 3 minutes)                                                   >> logs/result.log

ping 127.0.0.1 -n 180 > nul

echo %date% %time% ========================================================================================================================>> logs/result.log
echo %date% %time%  [Step6]                                                                                                                >> logs/result.log
echo %date% %time%                                                                                                                         >> logs/result.log
echo %date% %time%  Error handling                                                                                                         >> logs/result.log

ping 127.0.0.1 -n 1 > nul

echo %date% %time% ========================================================================================================================>> logs/result.log
echo %date% %time%  [End]                                                                                                                  >> logs/result.log
echo %date% %time%                                                                                                                         >> logs/result.log
echo %date% %time%  Batch is successfully executed                                                                                         >> logs/result.log
echo %date% %time% ========================================================================================================================>> logs/result.log
