import tkinter as tk
from tkinter import messagebox

class DoctorAppointmentApp(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Doctor Appointment App")
        self.geometry("400x350")

        # First name
        tk.Label(self, text="First name:").grid(row=0, column=0)
        self.first_name = tk.Entry(self)
        self.first_name.grid(row=0, column=1)

        # Last name
        tk.Label(self, text="Last name:").grid(row=1, column=0)
        self.last_name = tk.Entry(self)
        self.last_name.grid(row=1, column=1)

        # Age
        tk.Label(self, text="Age:").grid(row=2, column=0)
        self.age = tk.Entry(self)
        self.age.grid(row=2, column=1)

        # Gender
        tk.Label(self, text="Gender:").grid(row=3, column=0)
        self.is_male = tk.BooleanVar(self, True)
        tk.Checkbutton(self, text="Male", variable=self.is_male).grid(row=3, column=1)
        tk.Checkbutton(self, text="Female", variable=self.is_male, onvalue=False, offvalue=True).grid(row=3, column=2)

        # City
        tk.Label(self, text="City:").grid(row=4, column=0)
        self.city = tk.Entry(self)
        self.city.grid(row=4, column=1)

        # Address
        tk.Label(self, text="Address:").grid(row=5, column=0)
        self.address = tk.Entry(self)
        self.address.grid(row=5, column=1)

        # Username
        tk.Label(self, text="Username:").grid(row=6, column=0)
        self.username = tk.Entry(self)
        self.username.grid(row=6, column=1)

        # Password
        tk.Label(self, text="Password:").grid(row=7, column=0)
        self.password = tk.Entry(self, show="*")
        self.password.grid(row=7, column=1)

        # Verify Password
        tk.Label(self, text="Verify password:").grid(row=8, column=0)
        self.verify_password = tk.Entry(self, show="*")
        self.verify_password.grid(row=8, column=1)

        # Submit Button
        tk.Button(self, text="Sign Up", command=self.sign_up).grid(row=9, column=0)
        tk.Button(self, text="Clear", command=self.clear_fields).grid(row=9, column=1)

    def sign_up(self):
        first_name = self.first_name.get()
        last_name = self.last_name.get()
        age = self.age.get()
        gender = "Male" if self.is_male.get() else "Female"
        city = self.city.get()
        address = self.address.get()
        username = self.username.get()
        password = self.password.get()
        verify_password = self.verify_password.get()

        # Check if all fields are filled
        if not all((first_name, last_name, age, gender, city, address, username, password, verify_password)):
            tk.messagebox.showerror("Error", "Please fill in all the fields.")
            return

        # Check if passwords match
        if password != verify_password:
            tk.messagebox.showerror("Error", "Passwords do not match.")
            return

        # Print the information
        print("First Name:", first_name)
        print("Last Name:", last_name)
        print("Age:", age)
        print("Gender:", gender)
        print("City:", city)
        print("Address:", address)
        print("Username:", username)
        print("Password:", password)

        # Show success message
        tk.messagebox.showinfo("Success", "You have signed up successfully!")

    def clear_fields(self):
        # Clear all the fields
        self.first_name.delete(0, tk.END)
        self.last_name.delete(0, tk.END)
        self.age.delete(0, tk.END)
        self.is_male.set(True)
        self.city.delete(0, tk.END)
        self.address.delete(0, tk.END)
        self.username.delete(0, tk.END)
        self.password.delete(0, tk.END)
        self.verify_password.delete(0, tk.END)

if __name__ == "__main__":
    app = DoctorAppointmentApp()
    app.mainloop()
