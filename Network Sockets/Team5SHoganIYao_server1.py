#Team 5
#Sean Hogan K00276275
#Ishka Yao K0027040
#Server Socket

#  Run sockets in python 3

import socket
from contextlib import closing

HOST = '192.168.100.20'
PORT = 65432

class SocketContextManager:
    def __init__(self,conn):
        self.conn = conn
    def __enter__(self):
        return self.conn
    def __exit__(self, exc_type, exc_value, traceback):
        self.conn.close()
        
# Create a socket with address family IPv4 and socket type TCP
with closing(socket.socket(socket.AF_INET, socket.SOCK_STREAM)) as s:
    s.bind((HOST,PORT)) # Bind socket to specific IP and port
    s.listen(1) # Listen for incoming connection
    
    print("Server listening on {}:{}".format(HOST, PORT))
    print("")
    
    conn, addr = s.accept() # Accept connection
    
    print("----------")
    print("Connection accepted")
    print("Conn:")
    print(conn)
    print("Addr")
    print(addr)
    print("----------")
    print("")
    
    with SocketContextManager(conn) as conn: # Context manager for connection
        while True:
            data = conn.recv(1024) # Receive data from client
            print(data)
            print("")
            
            print("Validating")
            
            if not data:
                break
            
            name = data.decode()
            
            if name.isalnum(): # If alphanumerical send back data
                conn.sendall(("Name: " + name + "is alphanumerical").encode())
            else: # Else send back error
                conn.sendall(b'Invalid Name')
                
