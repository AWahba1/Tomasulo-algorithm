## Test Case 2
- assembly instructions  
```
S.D F6, 90
L.D F6, 120
ADD.D F7, F6, F5
MUL.D F6, F1, F2
DIV.D F7, F7, F2
S.D F7, 150
SUB.D F10,F7,F1
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
[L.D F6, 120, ADD.D F7, F6, F5, MUL.D F6, F1, F2, DIV.D F7, F7, F2, S.D F7, 150, SUB.D F10,F7,F1]
S.D F6, 90 is issued at station/buffer S0

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
1   | S0   | true  | 6.0 | null | 90
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, null), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, null), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------

Clock Cycle 2
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[ADD.D F7, F6, F5, MUL.D F6, F1, F2, DIV.D F7, F7, F2, S.D F7, 150, SUB.D F10,F7,F1]
L.D F6, 120 is issued at station/buffer L0

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
5   |  L0  | true  | 120
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | true  | 6.0 | null | 90
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, L0), (F7= 7.0, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, null), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Buffer S0 finished execution and has saved in the memory location 90 value= 6.0

Clock Cycle 3
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[MUL.D F6, F1, F2, DIV.D F7, F7, F2, S.D F7, 150, SUB.D F10,F7,F1]
ADD.D F7, F6, F5 is issued at station/buffer A0

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
3   |  A0  | ADD  | true  | 0.0 | 5.0 | L0 | null | 
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
4   |  L0  | true  | 120
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, L0), (F7= 7.0, A0), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, null), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Buffer L0 is currently executing
Buffer S0 is now emptied out

Clock Cycle 4
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[DIV.D F7, F7, F2, S.D F7, 150, SUB.D F10,F7,F1]
MUL.D F6, F1, F2 is issued at station/buffer M0

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
3   |  A0  | ADD  | true  | 0.0 | 5.0 | L0 | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
4   |  M0  | MUL  | true  | 1.0 | 2.0 | null | null | 
0   |  M1  | null | false | 0.0 | 0.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
3   |  L0  | true  | 120
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, M0), (F7= 7.0, A0), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, null), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Buffer L0 is currently executing

Clock Cycle 5
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[S.D F7, 150, SUB.D F10,F7,F1]
DIV.D F7, F7, F2 is issued at station/buffer M1

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
3   |  A0  | ADD  | true  | 0.0 | 5.0 | L0 | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
3   |  M0  | MUL  | true  | 1.0 | 2.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
2   |  L0  | true  | 120
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
0   | S0   | false | 0.0 | null | 0
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, M0), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, null), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M0 is currently executing
Buffer L0 is currently executing

Clock Cycle 6
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[SUB.D F10,F7,F1]
S.D F7, 150 is issued at station/buffer S0

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
3   |  A0  | ADD  | true  | 0.0 | 5.0 | L0 | null | 
0   |  A1  | null | false | 0.0 | 0.0 | null | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
2   |  M0  | MUL  | true  | 1.0 | 2.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
1   |  L0  | true  | 120
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, M0), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, null), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M0 is currently executing
Buffer L0 is currently executing

Clock Cycle 7
------------------------------------
------------------------------------

Instruction Queue
------------------------------------
[]
SUB.D F10,F7,F1 is issued at station/buffer A1

Add Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
3   |  A0  | ADD  | true  | 0.0 | 5.0 | L0 | null | 
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
1   |  M0  | MUL  | true  | 1.0 | 2.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | true  | 120
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, M0), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M0 is currently executing
Buffer L0 finished execution and output is 120.0

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
3   |  A0  | ADD  | true  | 120.0 | 5.0 | null | null | 
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | MUL  | true  | 1.0 | 2.0 | null | null | 
5   |  M1  | DIV  | true  | 0.0 | 2.0 | A0 | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 6.0, M0), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M0 finished execution and output is 2.0
Load Buffer L0 has written 120.0 on the bus and is emptied out

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
2   |  A0  | ADD  | true  | 120.0 | 5.0 | null | null | 
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
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
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A0 is currently executing
Station M0 has written 2.0 on the bus and is emptied out

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
1   |  A0  | ADD  | true  | 120.0 | 5.0 | null | null | 
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
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
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A0 is currently executing

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
0   |  A0  | ADD  | true  | 120.0 | 5.0 | null | null | 
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
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
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A0 finished execution and output is 125.0

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
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
5   |  M1  | DIV  | true  | 125.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A0 has written 125.0 on the bus and is emptied out

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
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
4   |  M1  | DIV  | true  | 125.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

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
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
3   |  M1  | DIV  | true  | 125.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 is currently executing

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
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
2   |  M1  | DIV  | true  | 125.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 is currently executing

Clock Cycle 16
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
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
1   |  M1  | DIV  | true  | 125.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 is currently executing

Clock Cycle 17
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
3   |  A1  | SUB  | true  | 0.0 | 1.0 | M1 | null | 
0   |  A2  | null | false | 0.0 | 0.0 | null | null | 

MUL Reservation Station
------------------------------------
Time| name | Type | Busy  | Vj  | Vk  | Qj   | Qk
0   |  M0  | null | false | 0.0 | 0.0 | null | null | 
0   |  M1  | DIV  | true  | 125.0 | 2.0 | null | null | 

Load Buffers
------------------------------------
Time| name | Busy  | effectiveAddress
0   |  L0  | false | 0
0   |  L1  | false | 0

Store Buffers
------------------------------------
Time| name | Busy  |  V  |  Q   | effectiveAddress
1   | S0   | true  | 0.0 | M1 | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 7.0, M1), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 finished execution and output is 62.5

Clock Cycle 18
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
3   |  A1  | SUB  | true  | 62.5 | 1.0 | null | null | 
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
1   | S0   | true  | 62.5 | null | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 62.5, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station M1 has written 62.5 on the bus and is emptied out

Clock Cycle 19
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
2   |  A1  | SUB  | true  | 62.5 | 1.0 | null | null | 
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
0   | S0   | true  | 62.5 | null | 150
0   | S1   | false | 0.0 | null | 0

Register File
------------------------------------
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 62.5, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A1 is currently executing
Buffer S0 finished execution and has saved in the memory location 150 value= 62.5

Clock Cycle 20
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
1   |  A1  | SUB  | true  | 62.5 | 1.0 | null | null | 
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
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 62.5, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A1 is currently executing
Buffer S0 is now emptied out

Clock Cycle 21
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
0   |  A1  | SUB  | true  | 62.5 | 1.0 | null | null | 
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
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 62.5, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 10.0, A1), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A1 finished execution and output is 61.5

Clock Cycle 22
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
[(F0= 0.0, null), (F1= 1.0, null), (F2= 2.0, null), (F3= 3.0, null), (F4= 4.0, null), (F5= 5.0, null), (F6= 2.0, null), (F7= 62.5, null), (F8= 8.0, null), (F9= 9.0, null), (F10= 61.5, null), (F11= 11.0, null), (F12= 12.0, null), (F13= 13.0, null), (F14= 14.0, null), (F15= 15.0, null), (F16= 16.0, null), (F17= 17.0, null), (F18= 18.0, null), (F19= 19.0, null), (F20= 20.0, null), (F21= 21.0, null), (F22= 22.0, null), (F23= 23.0, null), (F24= 24.0, null), (F25= 25.0, null), (F26= 26.0, null), (F27= 27.0, null), (F28= 28.0, null), (F29= 29.0, null), (F30= 30.0, null), (F31= 31.0, null)]

Logs
------------------------------------
Station A1 has written 61.5 on the bus and is emptied out


