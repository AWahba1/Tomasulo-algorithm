## Test Case 1
- assembly instructions  
```
L.D F10,100
MUL.D F12,F7,F13
ADD.D F5,F6,F11
DIV.D F6,F5,F2
SUB.D F4,F8,F9
S.D F20,50
```
- Latencies:
```
latencyADD=3;
latencySUB=3;
latencyMUL=4;
latencyDIV=5;
latencyLOAD=5;
latencySTORE=1;
```


Clock Cycle 1
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[MUL.D F12,F7,F13, ADD.D F5,F6,F11, DIV.D F6,F5,F2, SUB.D F4,F8,F9, S.D F20,50]
L.D F10,100 is issued at station/buffer L0

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
0   |  M1  | null | false | 0.0 | 0.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
5   |  L0  | true  | 100
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, null), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, L0), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------

Clock Cycle 2
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[ADD.D F5,F6,F11, DIV.D F6,F5,F2, SUB.D F4,F8,F9, S.D F20,50]
MUL.D F12,F7,F13 is issued at station/buffer M0

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
4   |  M0  | MUL  | true  | 7.0 | 13.0 | null | null | 
0   |  M1  | null | false | 0.0 | 0.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
4   |  L0  | true  | 100
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, null), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, L0), (F11= 11.0, null), (F12= 12.0, M0), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Buffer L0 is currently executing

Clock Cycle 3
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[DIV.D F6,F5,F2, SUB.D F4,F8,F9, S.D F20,50]
ADD.D F5,F6,F11 is issued at station/buffer A0

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
3   |  A0  | ADD  | true  | 6.0 | 11.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
3   |  M0  | MUL  | true  | 7.0 | 13.0 | null | null | 
0   |  M1  | null | false | 0.0 | 0.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
3   |  L0  | true  | 100
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, A0), (F6= 6.0, null), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, L0), (F11= 11.0, null), (F12= 12.0, M0), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M0 is currently executing
Buffer L0 is currently executing

Clock Cycle 4
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[SUB.D F4,F8,F9, S.D F20,50]
DIV.D F6,F5,F2 is issued at station/buffer M1

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
2   |  A0  | ADD  | true  | 6.0 | 11.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
2   |  M0  | MUL  | true  | 7.0 | 13.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
2   |  L0  | true  | 100
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, A0), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, L0), (F11= 11.0, null), (F12= 12.0, M0), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A0 is currently executing
Station M0 is currently executing
Buffer L0 is currently executing

Clock Cycle 5
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[S.D F20,50]
SUB.D F4,F8,F9 is issued at station/buffer A1

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
1   |  A0  | ADD  | true  | 6.0 | 11.0 | null | null | 
3   |  A1  | SUB  | true  | 8.0 | 9.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
1   |  M0  | MUL  | true  | 7.0 | 13.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
1   |  L0  | true  | 100
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, A1), (F5= 5.0, A0), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, L0), (F11= 11.0, null), (F12= 12.0, M0), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A0 is currently executing
Station M0 is currently executing
Buffer L0 is currently executing

Clock Cycle 6
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
S.D F20,50 is issued at station/buffer S0

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | ADD  | true  | 6.0 | 11.0 | null | null | 
2   |  A1  | SUB  | true  | 8.0 | 9.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | MUL  | true  | 7.0 | 13.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | true  | 100
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 20.0 | null | 50
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, A1), (F5= 5.0, A0), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, L0), (F11= 11.0, null), (F12= 12.0, M0), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A0 finished execution and output is 17.0
Station A1 is currently executing
Station M0 finished execution and output is 91.0
Buffer L0 finished execution and output is 100.0

Clock Cycle 7
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
-1   |  A0  | ADD  | true  | 6.0 | 11.0 | null | null | 
1   |  A1  | SUB  | true  | 8.0 | 9.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
-1   |  M0  | MUL  | true  | 7.0 | 13.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | true  | 20.0 | null | 50
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, A1), (F5= 5.0, A0), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 12.0, M0), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A1 is currently executing
Buffer S0 finished execution and has saved in the memory location 50 value= 20.0
Load Buffer L0 has written 100.0 on the bus and is emptied out

Clock Cycle 8
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
-2   |  A0  | ADD  | true  | 6.0 | 11.0 | null | null | 
0   |  A1  | SUB  | true  | 8.0 | 9.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, A1), (F5= 5.0, A0), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 91.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A1 finished execution and output is -1.0
Buffer S0 is now emptied out
Station M0 has written 91.0 on the bus and is emptied out

Clock Cycle 9
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
-1   |  A1  | SUB  | true  | 8.0 | 9.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
5   |  M1  | DIV  | true  | 17.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, A1), (F5= 17.0, null), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 91.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A0 has written 17.0 on the bus and is emptied out

Clock Cycle 10
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
4   |  M1  | DIV  | true  | 17.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= -1.0, null), (F5= 17.0, null), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 91.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 is currently executing
Station A1 has written -1.0 on the bus and is emptied out

Clock Cycle 11
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
3   |  M1  | DIV  | true  | 17.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= -1.0, null), (F5= 17.0, null), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 91.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 is currently executing

Clock Cycle 12
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
2   |  M1  | DIV  | true  | 17.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= -1.0, null), (F5= 17.0, null), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 91.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 is currently executing

Clock Cycle 13
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
1   |  M1  | DIV  | true  | 17.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= -1.0, null), (F5= 17.0, null), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 91.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 is currently executing

Clock Cycle 14
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
0   |  M1  | DIV  | true  | 17.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= -1.0, null), (F5= 17.0, null), (F6= 6.0, M1), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 91.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 finished execution and output is 8.5

Clock Cycle 15
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
No instructions issued in this cycle

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  A0  | null | false | 0.0 | 0.0 | null | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
0   |  M1  | null | false | 0.0 | 0.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= -1.0, null), (F5= 17.0, null), (F6= 8.5, null), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 100.0, null), (F11= 11.0, null), (F12= 91.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 has written 8.5 on the bus and is emptied out

